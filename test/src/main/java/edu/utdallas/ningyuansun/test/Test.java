package edu.utdallas.ningyuansun.test;

import java.nio.CharBuffer;

import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvocationType;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.LogType;
import com.amazonaws.util.StringUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvokeRequest request = new InvokeRequest();
		request.setFunctionName("testFunction");
		request.setPayload("\"\"");
		request.setInvocationType(InvocationType.RequestResponse);
		request.setLogType(LogType.Tail);
		BasicAWSCredentials credentials = new 
				  BasicAWSCredentials("AKIAJAQJK4R2O7PW2CDA", "es3W8EwMFNuWXA/BZnt0imjFjdyTSKXVPTVG/zhi");
		AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_2);
		AWSLambda lambda = builder.build();
		InvokeResult result = lambda.invoke(request);
		System.out.println(new String(result.getPayload().array(), StringUtils.UTF8));
	}

}
