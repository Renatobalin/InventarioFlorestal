package br.com.swinghibernate.view;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Renato_Balin
 */
public class RandonValidador extends fixedDocument
{
    private static final Logger LOG = getLogger(RandonValidador.class.getName());

    private char specialCharactersAllowed[];
    private boolean allSpecialCharacterAllowed;
    private boolean intAllowed;
    private boolean lettersAllowed;
    private boolean floatValidation;
    private boolean point;
    private int maximoCaracteres;
    private int taman;

    /**
     *
     * @param maxLen
     */
    public RandonValidador(int maxLen) {
        super(maxLen);
        taman = 5;
    }

    /**
     *
     * @param maxLenght
     * @param intAllowed
     * @param floatValidation
     * @param lettersAllowed
     * @param allSpecialCharacterAllowed
     * @param specialCharactersAllowed
     */
    public RandonValidador(int maxLenght, boolean intAllowed, boolean floatValidation, boolean lettersAllowed, boolean allSpecialCharacterAllowed, char specialCharactersAllowed[]) {
        super(maxLenght);
        taman = 5;
        this.intAllowed = intAllowed;
        this.floatValidation = floatValidation;
        this.lettersAllowed = lettersAllowed;
        this.allSpecialCharacterAllowed = allSpecialCharacterAllowed;
        this.specialCharactersAllowed = specialCharactersAllowed;
    }

    /**
     *
     * @param offset
     * @param str
     * @param attr
     * @throws BadLocationException
     */
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if(str == null || taman == maximoCaracteres) {
            return;
        }
        int tCampo = taman + str.length();
        if(tCampo <= maximoCaracteres) {
            insertString(offset, str.replaceAll("[^0-9|^,]", ""), attr);
        }
        String nova = str.substring(0, taman - maximoCaracteres);
        insertString(offset, nova, attr);
    }

    /**
     *
     * @param fb
     * @param offset
     * @param length
     * @param str
     * @param attr
     * @throws BadLocationException
     */
    @Override
    public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {
        byte n = 1;
        if(floatValidation) {
            if (length > 0) {
                int i = 0;
                do {
                    if (i >= length) {
                        break;
                    }
                    char c = fb.getDocument().getText(offset, length).charAt(i);
                    if(c == ',')
                    {
                        point = false;
                        break;
                    }
                    i++;
                } while (true);
            } else {
                int i = 0;
                do {
                    if (i >= fb.getDocument().getLength()) {
                        break;
                    }
                    char c = fb.getDocument().getText(0, fb.getDocument().getLength()).charAt(i);
                    if(c == ',')
                    {
                        point = true;
                        break;
                    }
                    point = false;
                    i++;
                } while (true);
            }
        }
        for(byte i = 0; i < str.length(); i++)
        {
            boolean isDigit = false;
            boolean isLetter = false;
            char c = str.charAt(i);
            if(isDigit(c) && !intAllowed)
            {
                n = 0;
                isDigit = true;
            } else
                if(isDigit(c)) {
                    isDigit = true;
                }
            if(getNumericValue(c) >= 10 && getNumericValue(c) <= 35 && (!lettersAllowed || floatValidation))
            {
                n = 0;
                isLetter = true;
            } else
                if(getNumericValue(c) >= 10 && getNumericValue(c) <= 35) {
                    isLetter = true;
                }
            if(!allSpecialCharacterAllowed && specialCharactersAllowed.length > 0 && !isLetter && !isDigit)
            {
                int k = 0;
                do
                {
                    if(k >= specialCharactersAllowed.length) {
                        break;
                    }
                    if(c != specialCharactersAllowed[k])
                    {
                        n = 0;
                    } else
                    {
                        n = 1;
                        break;
                    }
                    k++;
                } while(true);
            } else
                if(allSpecialCharacterAllowed && !isLetter && !isDigit) {
                    n = 1;
                } else
                    if(!isLetter && !isDigit) {
                        n = 0;
                    }
            if(!floatValidation) {
                continue;
            }
            if((c == ',') & point)
            {
                n = 0;
                continue;
            }
            if(c == ',')
            {
                n = 1;
                point = true;
            }
        }

        if(n != 0) {
            super.replace(fb, offset, length, str, attr);
        }
    }

    /**
     *
     * @return
     */
    public boolean isFloatValidation() {
        return floatValidation;
    }

    /**
     *
     * @param floatValidation
     */
    public void setFloatValidation(boolean floatValidation) {
        this.floatValidation = floatValidation;
    }

    /**
     *
     * @return
     */
    public boolean isIntAllowed() {
        return intAllowed;
    }

    /**
     *
     * @param intAllowed
     */
    public void setIntAllowed(boolean intAllowed) {
        this.intAllowed = intAllowed;
    }

    /**
     *
     * @return
     */
    public boolean isLettersAllowed() {
        return lettersAllowed;
    }

    /**
     *
     * @param lettersAllowed
     */
    public void setLettersAllowed(boolean lettersAllowed) {
        this.lettersAllowed = lettersAllowed;
    }

    /**
     *
     * @return
     */
    public char[] getSpecialCharactersAllowed() {
        return specialCharactersAllowed;
    }

    /**
     *
     * @param specialCharactersAllowed
     */
    public void setSpecialCharactersAllowed(char specialCharactersAllowed[]) {
        this.specialCharactersAllowed = specialCharactersAllowed;
    }

    /**
     *
     * @return
     */
    public boolean isAllSpecialChacacterAllowed() {
        return allSpecialCharacterAllowed;
    }

    /**
     *
     * @param allSpecialChacacterAllowed
     */
    public void setAllSpecialChacacterAllowed(boolean allSpecialChacacterAllowed) {
        allSpecialCharacterAllowed = allSpecialChacacterAllowed;
    }

    /**
     *
     * @return
     */
    public boolean hasPoint() {
        return point;
    }

    /**
     *
     * @param point
     */
    public void setPoint(boolean point) {
        this.point = point;
    }
}
