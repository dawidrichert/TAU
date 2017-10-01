package pl.edu.pjatk.tau.validators;

class PasswordValidator implements Validator {

    private String password;
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?#&])[A-Za-z\\d$@$!%*?#&]{8,}";

    public PasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public boolean isValid() {
        if(password != null) {
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(PASSWORD_PATTERN);
            java.util.regex.Matcher m = p.matcher(password);
            return m.matches();
        }
        return false;
    }
}
