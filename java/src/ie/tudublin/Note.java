package ie.tudublin;

public class Note {

  private char note;
  private int duration;

  public Note() {}

  public Note(char note, int duration) {
    this.note = note;
    this.duration = duration;
  }

  public char getNote() {
    return this.note;
  }

  public void setNote(char note) {
    this.note = note;
  }

  public int getDuration() {
    return this.duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return (
      getNote() +
      "     " +
      getDuration() +
      "     " +
      (getDuration() == 1 ? "Quaver" : "Crotchet")
    );
  }
}
