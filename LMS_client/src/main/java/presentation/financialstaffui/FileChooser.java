package presentation.financialstaffui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class FileChooser {
	
	private String address;
	private JFileChooser fileChooser;
	public FileChooser(JFrame ui){
		int result = 0;
		fileChooser = new JFileChooser();
		FileSystemView fsv = FileSystemView.getFileSystemView(); //注意了，这里重要的一句
		fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
		fileChooser.setDialogTitle("请选择导出的文件路径...");
		fileChooser.setApproveButtonText("确定");
//		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
		result = fileChooser.showOpenDialog(ui);
		if (JFileChooser.APPROVE_OPTION == result){
			address = fileChooser.getSelectedFile().getPath();
//			System.out.println("path: "+address);
		}
	}
	
	public String getAddress(){
		return address;
	}
	
}
