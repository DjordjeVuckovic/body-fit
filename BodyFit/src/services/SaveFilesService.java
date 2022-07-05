package services;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
@Path("files")
public class SaveFilesService {
	private String path1 = "C:\\Users\\djord\\OneDrive\\Documents\\GitHub\\WebProject\\vue-router-frontend\\src\\assets\\";
	private String path2 = "C:\\Users\\djord\\OneDrive\\Documents\\GitHub\\WebProject\\vue-router-frontend\\src\\assets\\trainings\\";

	@Context
	ServletContext ctx;
	
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("file") == null) {
			ctx.setAttribute("file", "");
		}
	}
	private String getLogosPath() {
		return path1;
	}
	private String getTrainingPhotoPath() {
		return path2;
	}
	@POST
	@Path("uploadFile")
	public void uploadFile(String name){

		ctx.setAttribute("file", name);
		System.out.println("File name set to: " + name);

	}

	@POST
	@Path("uploadTrainingPhoto")
	public void saveTrainingPhoto(String input) throws IOException {

		String imageString = input;
		String name = (String) ctx.getAttribute("file");
		byte[] decodedBytes = Base64.getDecoder().decode(imageString);
		BufferedImage buffImg = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		File file = new File(getTrainingPhotoPath() + name + ".png");
		ImageIO.write(buffImg, "png", file);
		System.out.println("Image " + name + ".png" + " uploaded.");

	}
	@POST
	@Path("editTrainingPhoto")
	public void editTrainingPhoto(String input) throws IOException {

		String imageString = input;
		String name = (String) ctx.getAttribute("file");
		byte[] decodedBytes = Base64.getDecoder().decode(imageString);
		BufferedImage buffImg = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		File file = new File(getTrainingPhotoPath() + name + ".png");
		ImageIO.write(buffImg, "png", file);
		System.out.println("Image " + name + ".png" + " uploaded.");

	}
	@POST
	@Path("uploadLogo")
	public void saveImageLogo(String input) throws IOException {

		String imageString = input;
		String name = (String) ctx.getAttribute("file");
		byte[] decodedBytes = Base64.getDecoder().decode(imageString);
		BufferedImage buffImg = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		File file = new File(getLogosPath() + name + ".png");
		ImageIO.write(buffImg, "png", file);
		System.out.println("Image " + name + ".png" + " uploaded.");

	}
	@POST
	@Path("sentLogo")
	public void sentImageLogo(String input) throws IOException {

		String imageString = input;
		String name = (String) ctx.getAttribute("file");
		byte[] decodedBytes = Base64.getDecoder().decode(imageString);
		BufferedImage buffImg = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		File file = new File(getLogosPath() + name + ".png");
		System.out.println("Name"+file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.canWrite());
		ImageIO.write(buffImg, "png", file);
		System.out.println("Image " + name + ".png" + " uploaded.");

	}

}
