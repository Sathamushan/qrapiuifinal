package  io.github.anantharajuc.sbmwa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController

@RequestMapping("/smjh/QR")
@Log4j2
@CrossOrigin
public class QRCodeController {

	String QR_CODE_IMAGE_PATH = "C:\\Users\\satham00553\\Downloads\\QRTEST";

	@GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{qrimageName}")
	public void download(@PathVariable("codeText") String codeText,@PathVariable("qrimageName")	String qrimageName)	throws Exception {
		String QR_CODE_IMAGE= QR_CODE_IMAGE_PATH+"\\"+qrimageName+".png";
		QRCodeGenerator.generateQRCodeImage(codeText, QR_CODE_IMAGE);
	}


	@GetMapping(value = "/genrateQRCode/{codeText}")
	public ResponseEntity<byte[]> generateQRCode(@PathVariable("codeText") String codeText) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, 260, 260));
	}
}
