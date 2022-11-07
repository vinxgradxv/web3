package com.example.web3_2;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public class YValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            String s = o.toString();
            double d = Double.parseDouble(s);
            if (d > 3 || d < -3) {
                throw new IndexOutOfBoundsException();
            }
        }

        catch (NullPointerException e) {
            FacesMessage msg = new FacesMessage("Can't be empty!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        catch (NumberFormatException e) {
            FacesMessage msg = new FacesMessage("Enter a number!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        catch (IndexOutOfBoundsException e) {
            FacesMessage msg = new FacesMessage("The number is out of borders!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
