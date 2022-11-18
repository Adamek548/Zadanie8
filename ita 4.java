package task4;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirAnalyser
{
    private final FileAnalyser fileAnalyser;

    public DirAnalyser(FileAnalyser fileAnalyser)
    {
        this.fileAnalyser = fileAnalyser;
    }

    public int countLettersForFilesWithExtension(String pathToFile, String extension)
    {
        File directory = new File(pathToFile);
        if (directory.exists() && directory.listFiles() != null)
        {
            List<File> files = Arrays.stream(directory.listFiles())
                    .filter(f -> f.getName().endsWith(extension))
                    .collect(Collectors.toList());
            int sum = 0;
            for (File file : files)
            {
                sum += fileAnalyser.countLetters(file.getAbsolutePath());
            }
            return sum;
        }
        return 0;
    }
}