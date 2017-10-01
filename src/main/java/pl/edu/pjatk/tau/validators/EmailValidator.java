package pl.edu.pjatk.tau.validators;

class EmailValidator implements Validator {

    private String email;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    public EmailValidator(String email) {
        this.email = email;
    }

    @Override
    public boolean isValid() {
        if(email != null) {
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(EMAIL_PATTERN);
            java.util.regex.Matcher m = p.matcher(email);
            return m.matches();
        }
        return false;
    }
}
