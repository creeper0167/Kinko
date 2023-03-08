package JcommanderClasses;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args {
    @Parameter(
            names = {"--file", "-F"},
            required = true
    )
    private String originalFile;

    @Parameter(
            names = {"--output", "-O"},
            required = true
    )
    private String outputName;

    @Parameter(
            names = {"--type", "-T"},
            required = true
    )
    private String type;

    public String getType() {
        return type;
    }

    public String getOriginalFile() {
        return originalFile;
    }

    public String getOutputName() {
        return outputName;
    }
}
