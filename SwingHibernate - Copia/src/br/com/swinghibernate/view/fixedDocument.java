package br.com.swinghibernate.view;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Renato_Balin
 */
public class fixedDocument extends DocumentFilter
{

    private static final Logger LOG = getLogger(fixedDocument.class.getName());
    private final int iMaxLength;

    /**
     *
     * @param maxLen
     */
    public fixedDocument(int maxLen) {
        iMaxLength = maxLen;
    }

    /**
     *
     * @param filterbypass
     * @param i
     * @param s
     * @param attributeset
     * @throws BadLocationException
     */
    @Override
    public void insertString(javax.swing.text.DocumentFilter.FilterBypass filterbypass, int i, String s, AttributeSet attributeset) throws BadLocationException {
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
        if(str == null) {
            return;
        }
        if(iMaxLength <= 0)
        {
            if(length == 0) {
                fb.insertString(offset, str, attr);
            } else {
                fb.replace(offset, length, str, attr);
            }
            return;
        }
        int ilen = fb.getDocument().getLength() + str.length();
        if(ilen <= iMaxLength)
        {
            if(length == 0) {
                fb.insertString(offset, str, attr);
            } else {
                fb.replace(offset, length, str, attr);
            }
        } else
        {
            if(fb.getDocument().getLength() == iMaxLength) {
                return;
            }
            String newStr = str.substring(0, iMaxLength - fb.getDocument().getLength());
            if(length == 0) {
                fb.insertString(offset, newStr, attr);
            } else {
                fb.replace(offset, length, newStr, attr);
            }
        }
    }
}
