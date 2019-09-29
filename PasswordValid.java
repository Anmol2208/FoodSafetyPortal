import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValid
{
    private Pattern pattern;
    private Matcher matcher;

    private static final String  RegExPassword =
                 "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
      // it should contain a digit(ie-//d), should contain small letters(ie-from a-z)
      //   it should contain Capital letters(ie-from A-Z), , should contain special Charecters(ie-@#$%)
      // the password should be from 6 to 20 characters long.
    public PasswordValid()                     //whenever the object is created constructor is called.
          {
        pattern = Pattern.compile(RegExPassword);
          }
    public boolean validate(final String password)
          {
        matcher = pattern.matcher(password);  //it will search for the password which is going to be matched.
        return matcher.matches();  //it will match with the RegExPassword.
          }

}