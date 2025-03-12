package com.agostinianas.demo.oauth.controller;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import java.util.List;

import java.util.Set;

import com.agostinianas.demo.core.domain.dto.CheckEmailDTO;
import com.agostinianas.demo.core.domain.dto.response.CheckEmailResponse;
import com.agostinianas.demo.core.domain.exception.NegocioException;
import com.agostinianas.demo.core.domain.service.ValidationService;
import com.agostinianas.demo.core.exception_handler.ProblemType;
import com.agostinianas.demo.oauth.domain.dto.AuthRequestDTO;
import com.agostinianas.demo.oauth.domain.dto.JwtResponseDTO;
import com.agostinianas.demo.oauth.domain.dto.RefreshTokenRequestDTO;
import com.agostinianas.demo.oauth.domain.dto.request.PasswordChangeRequest;
import com.agostinianas.demo.oauth.domain.dto.request.UserRequest;
import com.agostinianas.demo.oauth.domain.dto.response.PassRecoveryResponse;
import com.agostinianas.demo.oauth.domain.dto.response.UserResponse;
import com.agostinianas.demo.oauth.domain.repository.UserRepository;
import com.agostinianas.demo.oauth.domain.service.JwtService;
import com.agostinianas.demo.oauth.domain.service.RefreshTokenService;
import com.agostinianas.demo.oauth.domain.service.UserService;
import com.agostinianas.demo.oauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.agostinianas.demo.oauth.domain.entity.RefreshToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    public static final String EMAIL_VERIFICATION_TITLE = "verificação de email cadastrado";
    public static final String REQUEST_SUCCESS_MESSAGE = "Requisição Realizada com Sucesso";
    public static final String REQUEST_FAILED_MESSAGE = "Requisição realizada com falha";
    public static final String PASSWORD_RECOVERY_TITLE = "recuperação de senha";

    private final UserRepository iUserRepository;
    private final UserService userService;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    @Autowired
    private final ValidationService validation;
    private final BCryptPasswordEncoder passwordEncoder;
    

    @PatchMapping("/auth/user/{id}/password")
    public UserResponse changePassword(@PathVariable Long id,
                                       @RequestBody @Valid PasswordChangeRequest passwordChangeRequest) {

        return userService.changePassword(id, passwordChangeRequest.getNewPassword());

    }
    

    @GetMapping("/auth/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {

        var userInfo = userService.getUserById(id);
        var UserResponse = UserMapper.toResponse(userInfo);

        return ResponseEntity.ok(UserResponse);

    }


//    @PutMapping("/auth/user/{id}")
//    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
//        UserResponse userResponse = userService.updateUser(id, userRequest);
//        return ResponseEntity.ok(userResponse);
//    }


    @PostMapping("/auth/user")
    public UserResponse saveUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }


//    @GetMapping("/auth/users")
//    public ResponseEntity<Page<UserResponse>> getAllUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id,asc") String[] sort,
//            HttpServletRequest request) {
//        try {
//            Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
//            Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
//
//            Page<UserResponse> userResponses = userService.getAllUsersWithFilters(pageable, request);
//
//            return new ResponseEntity<>(userResponses, HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Erro ao buscar usuários", e);
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



    @PostMapping("/auth/profile")
    public ResponseEntity<UserResponse> getUserProfile() {
        UserResponse userResponse = userService.getUser();
        return ResponseEntity.ok().body(userResponse);
    }


    @PostMapping("/auth/login")
    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {

        return userService.authenticate(authRequestDTO);
    }



    @PostMapping("/auth/refresh-token")
    public JwtResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserInfo)
                .map(userInfo -> {
                    String accessToken = jwtService.GenerateToken(userInfo.getUsername());
                    return JwtResponseDTO.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequestDTO.getToken()).build();
                }).orElseThrow(() -> new NegocioException(ProblemType.RECURSO_NAO_ENCONTRADO, "Refresh Token não está no banco de dados"));
    }






    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/auth/user/complete-registration/{idUser}")
    public UserResponse completeRegistration(@PathVariable Long idUser) {
        return userService.completeRegistration(idUser);

    }

    private Set<ConstraintViolation<CheckEmailDTO>> getConstraintViolations(CheckEmailDTO checkEmail) {
        return validation.getValidator().validate(checkEmail);
    }


    private static PassRecoveryResponse getPassRecoveryResponseSuccess(List<PassRecoveryResponse.Object> objects, String errorMessages) {
        return PassRecoveryResponse.builder()
                .status(HttpStatus.ACCEPTED.value())
                .type(HttpStatus.ACCEPTED.getReasonPhrase())
                .detail(REQUEST_SUCCESS_MESSAGE)
                .title(PASSWORD_RECOVERY_TITLE)
                .userMessage(errorMessages)
                .objects(objects)
                .timestamp(OffsetDateTime.now())
                .build();
    }


    private static CheckEmailResponse getCheckEmailResponseError(String errorMessages) {
        return CheckEmailResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .type(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .detail(REQUEST_FAILED_MESSAGE)
                .title(EMAIL_VERIFICATION_TITLE)
                .userMessage(errorMessages)
                .timestamp(OffsetDateTime.now())
                .build();
    }

    private static CheckEmailResponse getCheckEmailResponseSuccess() {
        return CheckEmailResponse.builder()
                .status(HttpStatus.ACCEPTED.value())
                .type(HttpStatus.ACCEPTED.getReasonPhrase())
                .detail(REQUEST_SUCCESS_MESSAGE)
                .title(EMAIL_VERIFICATION_TITLE)
                .userMessage("Email encontra-se cadastrado")
                .timestamp(OffsetDateTime.now())
                .build();
    }

}
