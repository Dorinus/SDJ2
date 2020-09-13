public class JadenCase {

  public String toJadenCase(String phrase) {
    // TODO put your code below this comment

    if(phrase == null) return null;
    if(phrase.isEmpty()) return null;




    char[] letters = phrase.toCharArray();
    char temp;

    letters[0] = Character.toUpperCase(letters[0]);

    for(int i=0; i<letters.length; i++){
      if(letters[i]==' '){
       letters[i+1] = Character.toUpperCase(letters[i+1]);

      }
    }

    return new String(letters);
  }

}