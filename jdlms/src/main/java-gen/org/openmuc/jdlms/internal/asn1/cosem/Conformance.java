/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.types.BerBitString;

public class Conformance extends BerBitString {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.APPLICATION_CLASS,
			BerIdentifier.PRIMITIVE, 31);

	public Conformance() {
		id = identifier;
	}

	public Conformance(byte[] bitString, int numBits) {
		id = identifier;
		if ((numBits <= (((bitString.length - 1) * 8) + 1)) || (numBits > (bitString.length * 8))) {
			throw new IllegalArgumentException("numBits out of bound.");
		}

		this.value = bitString;
		this.numBits = numBits;
	}

	public int encode(BerByteArrayOutputStream berOStream) throws IOException {
		return encode(berOStream, true);
	}

	public int decode(InputStream iStream) throws IOException {
		return decode(iStream, true);
	}

}