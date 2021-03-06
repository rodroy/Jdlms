/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.axdr.compiler.axdrexample.generated;

import java.io.IOException;
import java.io.InputStream;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.*;
import org.openmuc.jdlms.internal.asn1.axdr.types.*;

public class Name implements AxdrType {

	public byte[] code = null;
	public AxdrVisibleString givenName = null;

	public AxdrVisibleString initial = null;

	public AxdrVisibleString familyName = null;

	public Name() {
	}

	public Name(byte[] code) {
		this.code = code;
	}

	public Name(AxdrVisibleString givenName, AxdrVisibleString initial, AxdrVisibleString familyName) {
		this.givenName = givenName;
		this.initial = initial;
		this.familyName = familyName;
	}

	public int encode(BerByteArrayOutputStream axdrOStream) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				axdrOStream.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			codeLength += familyName.encode(axdrOStream);
			
			codeLength += initial.encode(axdrOStream);
			
			codeLength += givenName.encode(axdrOStream);
			
		}

		return codeLength;

	}

	public int decode(InputStream iStream) throws IOException {
		int codeLength = 0;

		givenName = new AxdrVisibleString();
		codeLength += givenName.decode(iStream);

		initial = new AxdrVisibleString();
		codeLength += initial.decode(iStream);

		familyName = new AxdrVisibleString();
		codeLength += familyName.decode(iStream);

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(axdrOStream);
		code = axdrOStream.getArray();
	}
	public String toString() {
		return "sequence: {"+ "givenName: " + givenName + ", initial: " + initial + ", familyName: " + familyName  + "}";
	}

}

