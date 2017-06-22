package yjc.wdb.bbs.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	public static String uploadFile(String originalFilename, String uploadPath,byte[] bytes)throws Exception {
		
		
		System.out.println(uploadPath);
		UUID uid= UUID.randomUUID(); //유니크 한 아이디 고유한 아이디 설정할때 사용 무작위로 계속 던져줌
		int extIdx=originalFilename.lastIndexOf(".");
		String nameWithoutExtension= originalFilename.substring(0, extIdx);
		String saveName = uid.toString() + "_" + nameWithoutExtension;
		saveName += originalFilename.substring(extIdx);
		
		String savedPath=calculatePath(uploadPath);    //calculatepath 메소드 실행하면 /2017/05/12 string return 해준다.
		
		File target= new File(uploadPath+savedPath,saveName);//한폴더에 사진이 다 몰리지 않게 날짜 폴더 별로 사진이 쌓이게 한다.
		System.out.println(target.getAbsolutePath());
		
		FileCopyUtils.copy(bytes, target);
		
		//이미지 파일 이면 thunail 저장
		//아니면 아이콘 저장
		
		String thumbNailName="";
		
		String fileExtension=originalFilename.substring(extIdx+1);//파일 확장자
		if(MediaUtils.getMediaType(fileExtension.toLowerCase())!=null)//이미지 파일이면 null 이 아니다  혹시 대문자일수있으니 소문자로 바꿔서준다.
		{
			thumbNailName=makeThumbNail(uploadPath,savedPath,saveName);
		}else{
			thumbNailName=makeIcon(uploadPath,savedPath,saveName);
		}
	
		/*
		 * 
		 * 
		 *  original name: rose.jpg 라면
		 *  
		 *  rose_유니크한 아이디.jpg이렇게 만든다
		 */
		
		
		return thumbNailName;
	}

	
	
	private static String makeIcon(String uploadPath, String Path, String fileName)throws Exception {
		// TODO Auto-generated method stub
		
		String iconName=uploadPath + Path + File.separator+fileName;
		// resources/upload/2017/05/16/rose_asdkf;as.jpg
		
		
		return iconName.substring(uploadPath.length()).replace(File.separator, "/");// resources/upload 빼고
	}






	private static String makeThumbNail(String uploadPath, String Path, String fileName)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedImage sourceImg=ImageIO.read(new File(uploadPath+Path,fileName));
		
		BufferedImage destImg=Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		String thumbNailName=uploadPath+Path+File.separator+"thumbNail_"+fileName;
		
		File newFile= new File(thumbNailName);
		String fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, fileExtension.toLowerCase(), newFile);//썸네일 이미지 생성
		
		return thumbNailName.substring(uploadPath.length()).replace(File.separatorChar,'/'); 
		
		
	}






	private static String calculatePath(String uploadPath) {
		// TODO Auto-generated method stub
		
		Calendar cal= Calendar.getInstance();
		
		
		// /2017
		String yearPath= File.separator+cal.get(Calendar.YEAR);
		//file separator 는 운영체제에 따라서 파일 구분을 다르게 해준다. window는 \   unix 는 / 이다
		
		DecimalFormat df= new DecimalFormat("00");//05 06이런씩으로 만들어줘
		
		String monthPath= df.format(cal.get(Calendar.MONTH)+1);
		/* /2017/05 */
		
		monthPath= yearPath+File.separator+monthPath;
		
		// /2017/05/12
		String datePath=File.separator+df.format(cal.get(Calendar.DATE));
		
		datePath= monthPath+datePath;
		
		
		File folder= new File(uploadPath+datePath);
		if(folder.exists()==false)    //resources/upload/rose.jsp target은 rose이고 그것의 부모 파일은 upload 이다										
		{							//mkdirs 는 upload 파일 뿐만아니라 resources 폴더도 만들어라는 뜻
			folder.mkdirs();
		}
		
		return datePath;
	}
	
}
