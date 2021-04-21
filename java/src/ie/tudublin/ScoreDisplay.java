package ie.tudublin;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import processing.core.PApplet;

public class ScoreDisplay extends PApplet {

  ArrayList<Note> notes = new ArrayList<Note>();

  //   String score = "DEFGABcd";

  //   String score = "D2E2F2G2A2B2c2d2";

  String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

  public void settings() {
    size(1000, 500);

    // How to convert a character to a number
    char c = '7'; // c holds the character 7 (55)
    int i = c - '0'; // i holds the number 7 (55 - 48)
    println(i);
  }

  public void loadScore() {
    Note n = null;

    int i = 0;
    while (i < score.length() - 1) {
      char note;
      int duration = 1;

      if (Character.isDigit(score.charAt(i + 1)) == true) {
        duration = score.charAt(i + 1) - '0';
      }

      if (Character.isDigit(score.charAt(i)) == false) {
        note = score.charAt(i);

        n = new Note(note, duration);
        notes.add(n);
      }

      i++;
    }
  }

  public void printScores() {
    for (Note n : notes) {
      println(n);
    }
  }

  public void setup() {
    loadScore();
    printScores();

    border = width * 0.05f;
  }

  public void draw() {
    background(255);
    drawLines();
  }

  private float border;

  void drawLines() {
    for (int i = 0; i < 5; i++) {
      float y1 = map(i, 0, 5, height / 2, height - border);
      line(border, y1, width - border, y1);
    }
  }

  void drawNotes() {}
}
