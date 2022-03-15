package ro.pex.movie.service.email;

import org.springframework.core.io.ByteArrayResource;

public class FileByteArrayResource extends ByteArrayResource {

	private String fileName;

	public FileByteArrayResource(String fileName, byte[] byteArray, String description) {
		super(byteArray, description);
		this.fileName = fileName;
	}

	@Override
	public String getFilename() {
		return fileName;
	}
}
