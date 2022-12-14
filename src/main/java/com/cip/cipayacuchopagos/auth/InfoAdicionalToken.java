package com.cip.cipayacuchopagos.auth;

import java.util.HashMap;
import java.util.Map;

import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;





@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	private Logger logger = LoggerFactory.getLogger(InfoAdicionalToken.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		
		logger.info("GET NAME: " + authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		
		info.put("idUsuario", usuario.getIdusuario());
		info.put("nombre", usuario.getNombres());
		info.put("apellido", usuario.getAppaterno());
		info.put("email", usuario.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
