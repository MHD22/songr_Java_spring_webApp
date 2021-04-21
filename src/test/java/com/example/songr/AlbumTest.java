package com.example.songr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTest {

    @Test
    void testConstructorOfAlbumClass() {
        Album album1 = new Album("A7la w a7la", "Amr Diab","https://i.ytimg.com/vi/8IJIP1OUbMM/maxresdefault.jpg");
        String output = album1.toString();
        String expected = "Album{title='A7la w a7la', artist='Amr Diab', songCount=0, length=0, imageUrl='https://i.ytimg.com/vi/8IJIP1OUbMM/maxresdefault.jpg'}";
        assertEquals(expected,output);
    }

    @Test
    void testSetterAndGetterOfAlbumClass() {
        Album album1 = new Album("A7la w a7la", "Amr Diab","https://i.ytimg.com/vi/8IJIP1OUbMM/maxresdefault.jpg");
        album1.setSongCount(10);
        int output = album1.getSongCount();
        int expected = 10;
        assertEquals(expected,output);
    }


}
