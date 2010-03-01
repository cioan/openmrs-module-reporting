/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.reporting.dataset.definition;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.module.reporting.dataset.column.DataSetColumn;
import org.openmrs.module.reporting.dataset.column.SimpleDataSetColumn;
import org.openmrs.reporting.export.DataExportReportObject;
import org.openmrs.reporting.export.ExportColumn;

/**
 * Definition of a dataset that produces one-row-per-obs. Output might look like: 
 * 
 * patientId, question, questionConceptId, answer, answerConceptId, obsDatetime, encounterId 
 * 123, "WEIGHT (KG)", 5089, 70, null, "2007-05-23", 2345 
 * 123, "OCCUPATION", 987, "STUDENT", 988, "2008-01-30", 2658
 * 
 * @see DataExportDataSet
 */
public class DataExportDataSetDefinition extends BaseDataSetDefinition {
	
	/* Serial version UID */
    private static final long serialVersionUID = -2572061676651616176L;
	
	/* Data export object */
	private DataExportReportObject dataExport;
	/**
	 * Default public constructor 
	 */
	public DataExportDataSetDefinition() { 
		super();
	}
	
	/**
	 *  Public constructor
	 */
	public DataExportDataSetDefinition(DataExportReportObject dataExport) { 
		this.dataExport = dataExport;
	}
	
	/**
	 * @see DataSetDefinition#getColumns()
	 */
    public List<DataSetColumn> getColumns() {
		List<DataSetColumn> columns = new ArrayList<DataSetColumn>();
		for (ExportColumn exportColumn : dataExport.getColumns()) {
			String colName = exportColumn.getColumnName();
			// TODO: Add and retrieve dataType from ExportColumn
			columns.add(new SimpleDataSetColumn(colName, colName, String.class));
		}
		return columns;
	}

    
	public String getUuid() { 
		return dataExport.getUuid();
	}
	
	public void setUuid(String uuid) { 
		this.dataExport.setUuid(uuid);
	}
	
    
    /**
	 * @see DataSetDefinition#getId()
     */
    public Integer getId() { 
    	return dataExport.getReportObjectId();  	
    }    
    
    /**
	 * @see DataSetDefinition#getName()
     */
    public String getName() { 
    	return dataExport.getName();    	
    }

    /**
	 * @see DataSetDefinition#getDescription()
     */
    public String getDescription() { 
    	return dataExport.getDescription();    	
    }

    /**
     * Returns the data export object that backs this dataset definition.
     * @return	the data export object that backs this dataset definition
     */
    public DataExportReportObject getDataExportReportObject() {
    	return dataExport;
    }
    
    /**
     * Sets the data export model.
     * @param dataExport
     */
    public void setDataExportReportObject(DataExportReportObject dataExport) { 
    	this.dataExport = dataExport;
    }    
}