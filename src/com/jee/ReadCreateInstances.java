package com.jee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class ReadCreateInstances {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadCreateInstances rcInstances = new ReadCreateInstances();
		rcInstances.loadDataset("data/iris.arff");
		
		rcInstances.makeInstance();
	}
	
	 public void loadDataset(String fileName) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Instances readData = new Instances(reader);

				System.out.println("===== Loaded dataset: " + fileName + " =====");
				reader.close();
				readData.setClassIndex(readData.numAttributes() - 1);
				System.out.println(readData);
			}
			catch (IOException e) {
				System.out.println("Problem found when reading: " + fileName);
			}
		}
	 
	 public void makeInstance() {
			// Membuat Attribute List
			ArrayList<Attribute> attributeList = new ArrayList<Attribute>(5);

	                // Membuat 4 Attribute
			Attribute sepallength= new Attribute("sepallength");
			Attribute sepalwidth= new Attribute("sepalwidth");
			Attribute petallength= new Attribute("petallength");
			Attribute petalwidth= new Attribute("petalwidth");

	                // Membuatattribute kelas target
			ArrayList<String> classVal = new ArrayList<String>(2);
			classVal.add("Iris-setosa");
			classVal.add("Iris-versicolor");
			classVal.add("Iris-virginica");

			// Memasukkan Attribute ke Attribute List
			attributeList.add(sepallength);
			attributeList.add(sepalwidth);
			attributeList.add(petallength);
			attributeList.add(petalwidth);
			attributeList.add(new Attribute("class", classVal));

			// Instances baru dengan nama relasi "iris" dengan atributList dan index 0
			Instances instances = new Instances("iris", attributeList, 0);

			// Set Class Index untuk memberitahu kelas dari target, yang akan digunakan klasifikasi. kelas target berada pada atribut terakhir.
			instances.setClassIndex(instances.numAttributes() - 1);
			
			// Membuat dan tambah kan Attribute ke instance
			Instance inst_co = new DenseInstance(instances.numAttributes());
			
			// Men set nilai dari Attribute:
			inst_co.setValue(sepallength, 6.9);
			inst_co.setValue(sepalwidth, 3.1);
			inst_co.setValue(petallength, 5.1);
			inst_co.setValue(petalwidth, 2.3);

			//menambahkan instances dari instance inst_co
			instances.add(inst_co);
			System.out.println("===== Instance dataset =====");
			System.out.println(instances);
		}

}
