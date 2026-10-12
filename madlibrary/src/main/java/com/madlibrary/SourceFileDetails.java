package com.madlibrary;

import java.io.Serializable;

public class SourceFileDetails implements Serializable {
    private final String name;
    private final String assetPath;
    private final String projectPath;
    private final String fileType;
    private final boolean isExtra;

    public SourceFileDetails(String name, String assetPath, String projectPath, String fileType, boolean isExtra) {
        this.name = name;
        this.assetPath = assetPath;
        this.projectPath = projectPath;
        this.fileType = fileType;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getFileType() {
        return fileType;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String toString() {
        return name + " (" + fileType + (isExtra ? ", Extra" : "") + ")";
    }
}
