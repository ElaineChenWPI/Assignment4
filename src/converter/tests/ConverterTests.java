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
    public void valueOutBoundsNegativeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-3");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsMaxTestEdge() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsMaxTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9898385");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutBoundsZeroTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberFCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FCII");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberFCSeparateTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FIIC");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberCFTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CIFI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXSeparateTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NIIX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberNXMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMNXI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberYITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MalformedNumberYISeparateTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MYI");
    }


    @Test(expected = MalformedNumberException.class)
    public void MoreThanTripleMTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanTripleCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanTripleXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanTripleITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanFOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FFI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanNOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNFI");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanYOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMYY");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanDOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMDMD");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanLOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XLL");
    }

    @Test(expected = MalformedNumberException.class)
    public void MoreThanVOnceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XLL");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IM");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderYTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YMLS");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderVTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VYL");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XVYM");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderNTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NFV");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderLTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LVM");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CXM");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderFTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("FMC");
    }

    @Test(expected = MalformedNumberException.class)
    public void NotInOrderDTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DFM");
    }

    @Test
    public void ElbonianToArabicMSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void ArabicToElbonian55SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("55");
        assertEquals(converter.toElbonian(), "LV");
    }

    @Test
    public void ElbonianToArabicDSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("D");
        assertEquals(converter.toArabic(), 500);
    }

    @Test
    public void ElbonianToArabicFSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("F");
        assertEquals(converter.toArabic(), 400);
    }

    @Test
    public void ElbonianToArabicCSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("C");
        assertEquals(converter.toArabic(), 100);
    }

    @Test
    public void ElbonianToArabicLSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 50);
    }

    @Test
    public void ElbonianToArabicNSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("N");
        assertEquals(converter.toArabic(), 40);
    }

    @Test
    public void ElbonianToArabicXSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
    }

    @Test
    public void ElbonianToArabicVSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
    }
    @Test
    public void ArabicToElbonian1SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonian4SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4");
        assertEquals(converter.toElbonian(), "Y");
    }

    @Test
    public void ArabicToElbonian5SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("5");
        assertEquals(converter.toElbonian(), "V");
    }

    @Test
    public void ArabicToElbonian10SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10");
        assertEquals(converter.toElbonian(), "X");
    }

    @Test
    public void ArabicToElbonian40SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("40");
        assertEquals(converter.toElbonian(), "N");
    }

    @Test
    public void ArabicToElbonian50SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("50");
        assertEquals(converter.toElbonian(), "L");
    }

    @Test
    public void ArabicToElbonian100SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("100");
        assertEquals(converter.toElbonian(), "C");
    }

    @Test
    public void ArabicToElbonian400SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("400");
        assertEquals(converter.toElbonian(), "F");
    }

    @Test
    public void ArabicToElbonian500SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("500");
        assertEquals(converter.toElbonian(), "D");
    }

    @Test
    public void ArabicToElbonian1000SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1000");
        assertEquals(converter.toElbonian(), "M");
    }

    @Test
    public void ArabicToElbonian3999SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3999");
        assertEquals(converter.toElbonian(), "MMMDFLNVY");
    }

    @Test
    public void ArabicToElbonian15SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("15");
        assertEquals(converter.toElbonian(), "XV");
    }
    @Test
    public void ArabicToElbonian167SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("167");
        assertEquals(converter.toElbonian(), "CLXVII");
    }

    @Test
    public void ArabicToElbonian1341SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1341");
        assertEquals(converter.toElbonian(), "MCCCNI");
    }

    @Test
    public void ArabicToElbonian1999SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1999");
        assertEquals(converter.toElbonian(), "MDFLNVY");
    }

    @Test
    public void ArabicToElbonian2063SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2063");
        assertEquals(converter.toElbonian(), "MMLXIII");
    }

    @Test
    public void ArabicToElbonian555SampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("555");
        assertEquals(converter.toElbonian(), "DLV");
    }


    @Test
    public void ElbonianToArabicYSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Y");
        assertEquals(converter.toArabic(), 4);
    }

    @Test
    public void ElbonianToArabicISampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test
    public void ElbonianToArabicMMMSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMM");
        assertEquals(converter.toArabic(), 3000);
    }

    @Test
    public void ElbonianToArabicMMMDSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMD");
        assertEquals(converter.toArabic(), 3500);
    }

    @Test(expected = MalformedNumberException.class)
    public void ElbonianToArabicMCDSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCD");
    }

    @Test
    public void ElbonianToArabicDFSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DF");
        assertEquals(converter.toArabic(), 900);
    }

    @Test
    public void ElbonianToArabicDCSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DC");
        assertEquals(converter.toArabic(), 600);
    }

    @Test
    public void ElbonianToArabicCLSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CL");
        assertEquals(converter.toArabic(), 150);
    }

    @Test
    public void ElbonianToArabicLNSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LN");
        assertEquals(converter.toArabic(), 90);
    }

    @Test
    public void ElbonianToArabicLISampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LI");
        assertEquals(converter.toArabic(), 51);
    }


    @Test
    public void ElbonianToArabicVYSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VY");
        assertEquals(converter.toArabic(), 9);
    }

    @Test
    public void ElbonianToArabicVIISampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VII");
        assertEquals(converter.toArabic(), 7);
    }

    @Test
    public void ElbonianToArabicIISampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("II");
        assertEquals(converter.toArabic(), 2);
    }
}
