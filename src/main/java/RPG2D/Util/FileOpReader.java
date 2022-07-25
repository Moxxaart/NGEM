package RPG2D.Util;

import RPG2D.App;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;

public final class FileOpReader {

    public static boolean JRT = false;
    public static URI jrtBaseURI;               // jrt:/RPG2D
    public static URI GAME_DATA_PATH;           // /RPG2D/GameData/
    public static URI SETTINGS_PATH;

    private FileOpReader(){
        //---------
    }

    public static void initialization(){
        URL resource = App.class.getClassLoader().getResource("Credits.txt");
        if (resource == null || resource.getProtocol().equals("jrt")){
            FileOpReader.JRT = true;
            jrtBaseURI = URI.create("jrt:/RPG2D/");
        }
        if(JRT){
            GAME_DATA_PATH = URI.create(FileOpReader.jrtBaseURI + "/GameData");
            SETTINGS_PATH = URI.create(FileOpReader.jrtBaseURI + "Setting.ini");
            System.out.println(SETTINGS_PATH);
        } else {
            GAME_DATA_PATH = URI.create(String.valueOf(App.class.getResource("/GameData")));
            SETTINGS_PATH = URI.create(String.valueOf(App.class.getClassLoader().getResource("Setting.ini")));
        }
    }

    public static String[] getFileNameFromDir(URI targetDir){
        ArrayList<String> fileNameList = new ArrayList<>();
        String[] fileNames = new String[0];
        try{
            File[] files;
            if(targetDir.getScheme().equals("jrt")) {
                Path path = Path.of(targetDir);
                assert(Files.exists(path));
                FileSystem jrtFS = FileSystems.getFileSystem(URI.create("jrt:/"));
                assert(Files.exists(jrtFS.getPath(path.toString())));
                try{
                    DirectoryStream<Path> stream =Files.newDirectoryStream(jrtFS.getPath(path.toString()));
                    for (Path entry: stream) {
                        fileNameList.add(entry.getFileName().toString());
                    }
                    fileNames = fileNameList.toArray(new String[0]);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            files = new File(targetDir.getPath()).listFiles();
            if(files != null) {
                if(targetDir.getScheme().equals("jrt")) {
                    fileNames = new String[files.length];
                    for(int i=0; i< files.length; i++) {
                        if(files[i].isFile()) {
                            fileNames[i] =files[i].getName();
                        }
                    }
                } else {
                    System.out.println("Using JRT Filesystem");
                }
            } else {
                if(!targetDir.getScheme().equals("jrt")){
                    System.out.println("No files found in directory" + targetDir);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileNames;
    }

    public static String[] getFileLines (URI targetFile) {
        String[] toReturn = new String[0];
        try{
            toReturn =Files.readAllLines(Path.of(targetFile)).toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public static boolean doesFileExist (URI targetFile) {
        boolean answer = false;
        try {
            if(targetFile.getScheme().equals("jrt")) {
                Path path =Path.of(targetFile);
                assert(Files.exists(path));
                FileSystem jrtFS = FileSystems.getFileSystem(URI.create("jrt:/"));
                return Files.exists(jrtFS.getPath(path.toString()));
            } else {
                answer = new File(targetFile.getPath()).isFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

}
