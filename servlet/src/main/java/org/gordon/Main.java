package org.gordon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode jsonNode = xmlMapper.readTree("<ListUsersResponse xmlns=\"https://iam.amazonaws.com/doc/2010-05-08/\"> <ListUsersResult><IsTruncated>false</IsTruncated> <Users> <member>   <Path>/</Path>     <UserName>cicd</UserName>   <Arn>arn:aws:iam::733580349929:user/cicd</Arn>    <UserId>AIDA2VTGL2HUS7IQRXZM3</UserId>    <CreateDate>2022-07-13T09:34:42Z</CreateDate>   </member>  <member>          <Path>/</Path>  <UserName>jenkins-sqs-receiver</UserName>  <Arn>arn:aws:iam::733580349929:user/jenkins-sqs-receiver</Arn>     <UserId>AIDA2VTGL2HU7UOCOPXUR</UserId> <CreateDate>2022-05-29T05:01:18Z</CreateDate>    </member>     <member>         <Path>/</Path> <UserName>smax-smtp</UserName>        <Arn>arn:aws:iam::733580349929:user/smax-smtp</Arn>   <UserId>AIDA2VTGL2HUU26HXXVO3</UserId> <CreateDate>2022-05-02T15:08:51Z</CreateDate> </member>  </Users></ListUsersResult> <ResponseMetadata>   <RequestId>343d95ad-1c65-44da-acdf-359bc2bf3a04</RequestId>  </ResponseMetadata> </ListUsersResponse>".getBytes());

		JsonNode jsonNode1 = xmlMapper.readTree("<Flower>  <name>Poppy</name> <color>RED</color>   <petals>9</petals></Flower>".getBytes());

		ObjectMapper jsonMapper = new ObjectMapper();
		String json = jsonMapper.writeValueAsString(jsonNode);

		System.out.println(json);
	}
}