package task4;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirAnalyserTest
{
    @Test
    void test()
    {
        FileAnalyser fileAnalyser = new FileAnalyser();
        DirAnalyser dirAnalyser = new DirAnalyser(fileAnalyser);
        String pathToDir1 = pathGetter("dir1");
        String pathToDir2 = pathGetter("dir2");
        assertEquals(76, dirAnalyser.countLettersForFilesWithExtension(pathToDir1, "txt"));
        assertEquals(71, dirAnalyser.countLettersForFilesWithExtension(pathToDir1, "json"));
        assertEquals(209, dirAnalyser.countLettersForFilesWithExtension(pathToDir1, "xml"));
        assertEquals(0, dirAnalyser.countLettersForFilesWithExtension(pathToDir2, "txt"));
        assertEquals(0, dirAnalyser.countLettersForFilesWithExtension(pathToDir2, "json"));
        assertEquals(0, dirAnalyser.countLettersForFilesWithExtension(pathToDir2, "xml"));
    }

    private String pathGetter(String directory)
    {
        try
        {
            return Paths.get(getClass().getClassLoader().getResource(directory).toURI()).toString();
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}