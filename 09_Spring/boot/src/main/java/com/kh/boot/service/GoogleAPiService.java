package com.kh.boot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleAPiService {


    @Value ("${google.login-api.client-id}")
    private String googleLoginApiClientId;

    @Value("${google.login-api.redirect-url}")
    private String googleLoginApiRedirectUrl;

    @Value("${google.login-api.client-secret}")
    private String googleLoginApiClientSecret;

    public String requestGoogleEmail(String code) {
        String tokenResponse = requestGetGoogleToken(code);

        String assessToken = extractAcccessToken(tokenResponse);

        String userInfoResponse = getUserInfo(assessToken);

        String email = extractUserEmail(userInfoResponse);
        return email;
    }

    private String getUserInfo(String accessToken){
        String url = "https://www.googleapis.com/oauth2/v3/userinfo";

        //HTTP헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+accessToken);

        //get요청이므로 헤더만 포함한다.
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET, entity, String.class );

        return responseEntity.getBody();

    }
    private String extractUserEmail(String userInfoResponse){
        //UserInfo파싱해서 email 추출하기
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode jsonNode = mapper.readTree(userInfoResponse);
            return jsonNode.get("access_token").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            return null;
        }


    }

    private String extractAcccessToken(String tokenResponse){
        //JSon파싱해서 access_token추출하기

        ObjectMapper mapper = new ObjectMapper();



        try {
            JsonNode jsonNode = mapper.readTree(tokenResponse);
            return jsonNode.get("access_token").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            return null;
        }


    }
    private String requestGetGoogleToken(String code) {

        String url = "https://oauth2.googleapis.com/token";

        //파라미터 설정 -> 토큰 요청보낼때 필수로 보내야하는 정보
        String params = "code=" + code + "&grant_type=authorization_code"
                + "&client_id=" + googleLoginApiClientId
                + "&client_secret=" + googleLoginApiClientSecret
                + "&redirect_uri=" + googleLoginApiRedirectUrl;


        //HTTP 헤더를 설정
        HttpHeaders headers = new HttpHeaders();
        //보내줄 데이터타입을 정한다.(구글문서에 작성되어 있음 : 폼타입)
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // 폼타입이다

        //HTTP POST요청 전달
        HttpEntity<String> entity = new HttpEntity<>(params,headers);
        RestTemplate restTemplate = new RestTemplate();

        //구글 토큰 POST요청
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        //응답 결과 반환
        return responseEntity.getBody();

    }

}


//    public List<File> getGoogleForms(String accessToken) {
//        Drive driveService = getDriveService(accessToken);
//
//        FileList result = null;
//        try {
//            result = driveService.files().list()
//                    .setQ("mimeType='application/vnd.google-apps.form'")             //검색필터
//                    .setSpaces("drive")
//                    .setFields("files(id, name, createdTime)")
//                    .execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return result.getFiles();
//    }
//
//    //accesstoken을 사용해서 google drive service초기화
//    private Drive getDriveService(String accessToken) {
//        Drive driveService = null;
//        try {
//            //googleApi 요청을 보낼 때 사용하는 안전한 HTTP클라이언트 설정
//            final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//            //응답 json을 직렬화/역직렬화하기위한 파셔
//            final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
//
//            //구글 인증정보를 담는 객체 -> access_token을 통해서 직접 인증
//            GoogleCredential credential = new GoogleCredential.Builder()
//                    .setTransport(httpTransport)
//                    .setJsonFactory(jacksonFactory)
//                    .setClientSecrets(googleLoginApiClientId, gooleLoginApiClientSecret)
//                    .build()
//                    .setAccessToken(accessToken);
//
//            //driveService를 가져오면
//            driveService = new Drive.Builder(httpTransport, jacksonFactory, credential)
//                    .setApplicationName("spring-test-app")
//                    .build();
//        } catch (GeneralSecurityException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return driveService;
//    }
//}
