package com.example.appsb.sqlitedemo;

/**
 * Created by appsb on 13-07-2018.
 */

public interface constants {

    int DATABASE_VERSION = 1;

    String DB_NAME="wordGame.db";

    String TB_WORD="wordTB";
    String WORD_WORDID="wordID";
    String WORD_WORD="word";

    String TB_IMAGE="imageTB";
    String IMAGE_IMAGID="imgID";
    String IMAGE_IMAGENAME="imgNM";
    String IMAGE_WORD_ID="wordID";
}
