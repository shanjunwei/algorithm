package tree;

import java.io.File;

/**
 * Created by bruce on 2018/6/3.
 *  Linux 的Tree命令
 */
public class LinuxTree {
    public void printAll(File file, int depth){
        printFileName(file,depth);

        if(file.isDirectory()){
            for(File child  : file.listFiles()){
                printAll(child,depth+1);
            }
        }
    }
    // 打印文件名
    public void printFileName(File file, int depth){
        if(depth < 0 || file==null)
            return;
        if(depth == 0){
            System.out.println("\\"+file.getName()+"\\");
        }else{
            for (int i = 0; i < depth-1; i++) {
                System.out.print("|");
                System.out.print("\t");
            }
            System.out.println("|__ "+file.getName());
        }
    }


    public static void main(String[] args) {

        LinuxTree  linuxTree = new LinuxTree();
        File  file = new File("D:\\FunApp");
        linuxTree.printAll(file,0);
}
}
