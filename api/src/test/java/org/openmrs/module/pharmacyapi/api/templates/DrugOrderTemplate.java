package org.openmrs.module.pharmacyapi.api.templates;

import org.openmrs.CareSetting;
import org.openmrs.Concept;
import org.openmrs.Drug;
import org.openmrs.DrugOrder;
import org.openmrs.OrderFrequency;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class DrugOrderTemplate implements TemplateLoader {
	
	public static final String VALID_PROFLAXIA_01 = "VALID_PROFLAXIA_01";
	
	@Override
	public void load() {
		
		Fixture.of(DrugOrder.class).addTemplate(VALID_PROFLAXIA_01, new Rule() {
			
			{
				this.add("dateCreated", this.instant("now"));
				this.add("drug", this.one(Drug.class, DrugTemplate.TRIOMUNE30));
				this.add("dose", new Double(2));
				this.add("doseUnits", this.one(Concept.class, ConceptTemplate.MG_DOSE_UNITS));
				this.add("frequency", this.one(OrderFrequency.class, OrderFrequencyTemplate.FREQUENCY_ONCE_A_DAY));
				this.add("quantityUnits", this.one(Concept.class, ConceptTemplate.TABS_QUANTITY_UNITS));
				this.add("duration", new Integer(3));
				this.add("durationUnits", this.one(Concept.class, ConceptTemplate.DURATION_WEEKS));
				this.add("careSetting", this.one(CareSetting.class, CareSettingTemplate.INPATIENT));
				this.add("route", this.one(Concept.class, ConceptTemplate.ROUTE_UNKNOWN));
				this.add("concept", this.one(Concept.class, ConceptTemplate.TRIOMUNE30));
			}
		});
		
	}
	
}