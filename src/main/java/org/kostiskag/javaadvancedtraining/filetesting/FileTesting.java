package filetesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTesting {

    public static void main(String[] args)  {
        try (var s = Files.newDirectoryStream(Path.of("C:\\Users\\kostis\\Tor Browser"))) {
            s.forEach( f -> {
                //System.out.println(f.getFileName());
                if (f.getFileName().toString().endsWith(".jpg") || f.getFileName().toString().endsWith(".gif")) {
                    System.out.println(f.getFileName());
                }
            });
        } catch (IOException e) {

        }

        System.out.println("tree!!!");
        //var vi =

        try {
            Files.walkFileTree(Path.of("C:\\Users\\kostis\\Tor Browser"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    //System.out.println(file.getFileName().toString());
                    if (file.getFileName().toString().endsWith(".jpg") || file.getFileName().toString().endsWith(".gif")) {
                        System.out.println(file.getFileName());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {

        }

    }
}

