package com.Ty.user.userDetails.util;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.SerializationUtils;

import lombok.SneakyThrows;

public class AesEncryption implements AttributeConverter<Object, String> {
	
	@Value("${aes.encryption.key}")
	private String encriptionkey="";
	private String encriptioncipher="AES";
	
	private Key key;
	private Cipher cipher;
	
	private Key getKey() {
		if(key==null) {
			key=new SecretKeySpec(encriptionkey.getBytes(), encriptioncipher);
		}
		return key;
	}

	private Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		if(cipher==null) {
			cipher=Cipher.getInstance(encriptioncipher);
		}
		return cipher;
	}
private void initCipher(int encription) throws GeneralSecurityException, NoSuchAlgorithmException, NoSuchPaddingException {
	getCipher().init(encription, getKey());
}
@SneakyThrows
	@Override
	public String convertToDatabaseColumn(Object attribute) {
if(attribute==null)
	return null;
initCipher(Cipher.ENCRYPT_MODE);
byte[] bytes=SerializationUtils.serialize(attribute);
return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
	}
@SneakyThrows
	@Override
	public Object convertToEntityAttribute(String dbData) {
	if(dbData==null)
		return null;
	initCipher(Cipher.DECRYPT_MODE);
	byte[] bytes=getCipher().doFinal(Base64.getDecoder().decode(dbData));
	return SerializationUtils.deserialize(bytes);
	}
	

}
