package ro.pex.movie.model.dto;

public class EmailAttachmentDto {

	private String fileName;
	private byte[] fileContent;

	public EmailAttachmentDto(String fileName, byte[] fileContent) {
		super();
		this.fileName = fileName;
		this.fileContent = fileContent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
