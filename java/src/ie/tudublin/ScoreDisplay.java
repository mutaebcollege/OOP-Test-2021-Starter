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
  }

  public void loadScore() {
    Note n = null;

    int i = 0;
    while (i < score.length()) {
      char note;
      int duration = 1;

      if (i + 1 != score.length()) {
        if (Character.isDigit(score.charAt(i + 1)) == true) {
          duration = score.charAt(i + 1) - '0';
        }
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
    drawNotes();
    // colorMode(HSB);

  }

  private float border;

  void drawLines() {
    for (int i = 0; i < 5; i++) {
      float y1 = map(i, 0, 5, height / 2, height - border);
      line(border, y1, width - border, y1);
    }
  }

  void drawNotes() {
    textAlign(CENTER, CENTER);
    textSize(20);

    for (int i = 0; i < notes.size(); i++) {
      Note n = notes.get(i);
      stroke(0);
      fill(0);
      float x1 = map(i, 0, notes.size(), border * 2, width - border);

      text(n.getNote(), x1, height / 2 - border);

      char c = n.getNote();
      String scale = "DEFGABcd";
      int index = scale.indexOf(c);

      int sub = 20 * index;

      if (mouseX >= x1 - 20 && mouseX <= x1 + 20) {
        fill(fillColor, 0, 0);
        stroke(fillColor, 0, 0);
      }

      circle(x1, height / 2 + 180 - sub, 40);
      line(x1 + 20, height / 2 - sub + 80, x1 + 20, height / 2 + 180 - sub);
      if (n.getDuration() == 2) {
        line(
          x1 + 20,
          height / 2 - sub + 80,
          x1 + 20 + 20,
          height / 2 + 180 - sub - 80
        );
      }
    }

    stroke(0);
    fill(0);
  }

  int fillColor = 150;
  //   public void mouseDragged() {
  //     fillColor = 150;
  //   }
}
