/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.iso.acse;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;

public class ACSE_apdu {

	public byte[] code = null;
	public AARQ_apdu aarq = null;

	public AARE_apdu aare = null;

	public RLRQ_apdu rlrq = null;

	public RLRE_apdu rlre = null;

	public ACSE_apdu() {
	}

	public ACSE_apdu(byte[] code) {
		this.code = code;
	}

	public ACSE_apdu(AARQ_apdu aarq, AARE_apdu aare, RLRQ_apdu rlrq, RLRE_apdu rlre) {
		this.aarq = aarq;
		this.aare = aare;
		this.rlrq = rlrq;
		this.rlre = rlre;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (rlre != null) {
			codeLength += rlre.encode(os, true);
			return codeLength;

		}

		if (rlrq != null) {
			codeLength += rlrq.encode(os, true);
			return codeLength;

		}

		if (aare != null) {
			codeLength += aare.encode(os, true);
			return codeLength;

		}

		if (aarq != null) {
			codeLength += aarq.encode(os, true);
			return codeLength;

		}

		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream is, BerIdentifier berIdentifier) throws IOException {
		int codeLength = 0;
		BerIdentifier passedIdentifier = berIdentifier;

		if (berIdentifier == null) {
			berIdentifier = new BerIdentifier();
			codeLength += berIdentifier.decode(is);
		}
		if (berIdentifier.equals(AARQ_apdu.identifier)) {
			aarq = new AARQ_apdu();
			codeLength += aarq.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(AARE_apdu.identifier)) {
			aare = new AARE_apdu();
			codeLength += aare.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(RLRQ_apdu.identifier)) {
			rlrq = new RLRQ_apdu();
			codeLength += rlrq.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(RLRE_apdu.identifier)) {
			rlre = new RLRE_apdu();
			codeLength += rlre.decode(is, false);
			return codeLength;
		}

		if (passedIdentifier != null) {
			return 0;
		}
		throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	@Override
	public String toString() {
		if (aarq != null) {
			return "CHOICE{aarq: " + aarq + "}";
		}

		if (aare != null) {
			return "CHOICE{aare: " + aare + "}";
		}

		if (rlrq != null) {
			return "CHOICE{rlrq: " + rlrq + "}";
		}

		if (rlre != null) {
			return "CHOICE{rlre: " + rlre + "}";
		}

		return "unknown";
	}

}
