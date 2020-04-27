package com.glx.oa.entity;

public class MyFile {

    private String fileName;

    private String fileLength;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLength() {
        return fileLength;
    }

    public Boolean deleteFile(){
        return true;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

}
