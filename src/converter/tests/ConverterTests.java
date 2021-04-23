package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {



    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLowerCaseTestEdge1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mkjgh");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLowerCaseTestEdge2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mKlgU");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLowerCaseTestEdge() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MKlgU");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberLowerCaseMixedTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MK03");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsNegativeTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-3");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsMaxTestEdge() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsMaxTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9898385");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsZeroTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberFCTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FCII");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberFCSeparateTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FIIC");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberCFTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CIFI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXSeparateTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NIIX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMNXI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberYITest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberYISeparateTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MYI");
    }


}
