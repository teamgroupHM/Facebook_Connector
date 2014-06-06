package com.happiestminds.socialconnectors.facebook;

import java.util.HashMap;

public class TableFactory {
		@SuppressWarnings("rawtypes")
		public static HashMap m_RegisteredTables = new HashMap();

		@SuppressWarnings("unchecked")
		public static void registerProduct (String tableID, ITable tableClass){
			m_RegisteredTables.put(tableID, tableClass);
		}

		/*public ITable createProduct(String tableID){
			return ((ITable)m_RegisteredTables.get(tableID)).createTable();
		}*/
}
