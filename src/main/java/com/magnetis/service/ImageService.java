package com.magnetis.service;


/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Cacheable(cacheNames = "qr-code-cache", sync = true)
public class ImageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class);

	public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {

		Assert.hasText(text);
		Assert.isTrue(width > 0);
		Assert.isTrue(height > 0);
		
		LOGGER.info("Will generate image  text=[{}], width=[{}], height=[{}]", text, width, height);

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
		MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		return baos.toByteArray();
	}

	@Async
	public ListenableFuture<byte[]> generateQRCodeAsync(String text, int width, int height) throws Exception {
		return new AsyncResult<byte[]>(generateQRCode(text, width, height));
	}
	
	@CacheEvict(cacheNames = "qr-code-cache", allEntries = true)
	public void purgeCache() {
		LOGGER.info("Purging cache");
	}

}