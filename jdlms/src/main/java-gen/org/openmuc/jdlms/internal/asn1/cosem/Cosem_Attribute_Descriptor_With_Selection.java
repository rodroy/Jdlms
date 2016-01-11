/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOptional;

public class Cosem_Attribute_Descriptor_With_Selection implements AxdrType {

	public byte[] code = null;
	public Cosem_Attribute_Descriptor cosem_attribute_descriptor = null;

	public AxdrOptional<Selective_Access_Descriptor> access_selection = new AxdrOptional<Selective_Access_Descriptor>(
			new Selective_Access_Descriptor(), false);

	public Cosem_Attribute_Descriptor_With_Selection() {
	}

	public Cosem_Attribute_Descriptor_With_Selection(byte[] code) {
		this.code = code;
	}

	public Cosem_Attribute_Descriptor_With_Selection(Cosem_Attribute_Descriptor cosem_attribute_descriptor,
			Selective_Access_Descriptor access_selection) {
		this.cosem_attribute_descriptor = cosem_attribute_descriptor;
		this.access_selection.setValue(access_selection);
	}

	@Override
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
			codeLength += access_selection.encode(axdrOStream);

			codeLength += cosem_attribute_descriptor.encode(axdrOStream);

		}

		return codeLength;

	}

	@Override
	public int decode(InputStream iStream) throws IOException {
		int codeLength = 0;

		cosem_attribute_descriptor = new Cosem_Attribute_Descriptor();
		codeLength += cosem_attribute_descriptor.decode(iStream);

		access_selection = new AxdrOptional<Selective_Access_Descriptor>(new Selective_Access_Descriptor(), false);
		codeLength += access_selection.decode(iStream);

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(axdrOStream);
		code = axdrOStream.getArray();
	}

	@Override
	public String toString() {
		return "sequence: {" + "cosem_attribute_descriptor: " + cosem_attribute_descriptor + ", access_selection: "
				+ access_selection + "}";
	}

}
