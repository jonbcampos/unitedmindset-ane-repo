/*

Copyright (C) 2012 Jonathan Campos

Permission is hereby granted, free of charge, to any person 
obtaining a copy of this software and associated documentation 
files (the "Software"), to deal in the Software without 
restriction, including without limitation the rights to use, 
copy, modify, merge, publish, distribute, sublicense, and/or 
sell copies of the Software, and to permit persons to whom 
the Software is furnished to do so, subject to the following 
conditions:

The above copyright notice and this permission notice shall 
be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
OTHER DEALINGS IN THE SOFTWARE.

*/
package com.unitedmindset.opendocument.extensions;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class OpenDocumentFunction implements FREFunction {

	public static final String QUICK_OFFICE_URL = "https://market.android.com/search?q=quick+office&so=1&c=apps";
    public static final String QUICK_OFFICE_TRIAL_PACKAGE = "com.qo.android.am3.trial";
    public static final String QUICK_OFFICE_PACKAGE = "com.qo.android.am3";
    public static final String ADOBE_READER_URL="https://market.android.com/search?q=adobe+reader&so=1&c=apps";
    public static final String ADOBE_READER_PACKAGE="com.adobe.reader";
    public static final String DOCUMENTS_TO_GO_PACKAGE = "com.dataviz.docstogo";
    public static final String GOOGLE_DOCUMENT_PACKAGE ="com.google.android.apps.docs";
    public static final String OPEN_OFFICE_PACKAGE = "at.tomtasche.reader";
    public static final String BEAMREADER_PACKAGE = "com.slgmobile.beamreader";
    public static final String PDFVIEWER_PACKAGE = "mobi.mgeek.pdfviewer";
    public static final String ANDROID_PDF_VIEWER_PACKAGE = "net.sf.andpdf.pdfviewer";
    public static final String EZ_READER = "udk.android.reader";
    public static final String PDF_VIEWER = "com.dzepina.pdfviewer";
	
	public FREObject call(FREContext context, FREObject[] args)
	{
		OpenDocumentContext c = (OpenDocumentContext)context;
		Activity activity = c.getActivity();
		
		//get vars
		String path = "";
		try {
			path = args[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		String extension = "";
		try {
			extension = args[1].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		File file = new File(path);
		if(!file.exists())
			return null;
		
		String type = "";
		if(extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("docx"))
		{
			type = "application/msword";
		} else if(extension.equalsIgnoreCase("pdf"))
		{
			type = "application/pdf";
		} else {
			type = "application/*";
		}
		
		//create intent
		Intent intent = new Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), type);
		activity.startActivity(intent);
		return null;
	}
	
}
