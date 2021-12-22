package com.som.security.security.authentication;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebAuthenticationProvider implements AuthenticationProvider{
    
    private final Logger logger = LogManager.getLogger(WebAuthenticationProvider.class);
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String userPassword = authentication.getCredentials().toString();        

        logger.info("userID : " + userId);
        logger.info("userPassword : " + userPassword);

        if(userId.equals("test") && userPassword.equals("test")){
            logger.error("아이디: "+userId);
        }
  
        // 권한 토큰 생성
        if (userId.equals("test")) {
           ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
           authorities.add(new SimpleGrantedAuthority("user"));
           //Long authId = user.getAuthorityGroupId().getAuthorityGroupId();
            
            // for (ArmsAuthorityDetail auths : this.armsAuthorityRepository
            //     .findByAuthorityIdAuthorityGroupIdAuthorityGroupId(authId)
            // ) {
            //     String authType = auths.getAuthorityClassId().getAuthorityClassName();
            //     String funcName = auths.getAuthorityId().getAuthorityFunctionId().getAuthorityFunctionRole();

            //     if(user.getUserId().equals("admin")){
            //         authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            //     }

            //     if(user.getUserStatus() <5) { // 5부터 비활성화 상태
            //         if(!authType.equals("F")){
            //             if(authType.equals("T_W")) { // T_W일때는 T_R까지 권한 준다.
            //                 authorities.add(new SimpleGrantedAuthority("ROLE_"+funcName+"_"+authType));
            //                 authorities.add(new SimpleGrantedAuthority("ROLE_"+funcName+"_"+"T_R"));
            //             }    
            //             if(authType.equals("T_R")) {
            //                 authorities.add(new SimpleGrantedAuthority("ROLE_"+funcName+"_"+authType));
            //             } 
            //         }
            //     }
            
                        UsernamePasswordAuthenticationToken aToken = (
                            new UsernamePasswordAuthenticationToken(
                                "test", 
                                null,
                                authorities
                            )
                        );
                        return aToken;
            }
            // final UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
    
        //     logger.info("login success for user : " + authentication.getName());
        //     logger.info("authorities : " + authorities);
            
        //     return aToken;
        // }
        else {
            throw new BadCredentialsException("user not found"); // 비밀번호 일치 실패
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }    
}
