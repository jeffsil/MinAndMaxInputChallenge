package com.logicgate.farm.service;

import com.logicgate.farm.domain.Animal;
import com.logicgate.farm.domain.Barn;
import com.logicgate.farm.repository.AnimalRepository;
import com.logicgate.farm.repository.BarnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  private final BarnRepository barnRepository;
  private int addCount = 0;
  private int deleteCount = 0;

  @Autowired
  public AnimalServiceImpl(AnimalRepository animalRepository, BarnRepository barnRepository) {
    this.animalRepository = animalRepository;
    this.barnRepository = barnRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Animal> findAll() {
    return animalRepository.findAll();
  }

  @Override
  public void deleteAll() {
    animalRepository.deleteAll();
  }

  @Override
  public Animal addToFarm(Animal animal) {


//    addCount++;
//    System.out.println("ADD COUNT IS " +addCount);
    List<Animal> animalResult = findAll();
    Map<Barn, List<Animal>> barnAnimalMap = animalResult.stream()
      .collect(Collectors.groupingBy(Animal::getBarn));

    List<Barn> matchingBarnsList = new ArrayList<>();
    boolean barnFound = false;
    long barnCount = barnRepository.count();
    Barn barnFoundObj;


    if (barnCount == 0) {
      Barn tempBarn = new Barn(animal.getFavoriteColor().toString(), animal.getFavoriteColor());
      barnRepository.save(tempBarn);
      Animal tempAnimal = new Animal(animal.getName(), animal.getFavoriteColor(),
        tempBarn);
      animalRepository.save(tempAnimal);
      return tempAnimal;
    }

    for (Map.Entry<Barn, List<Animal>> e : barnAnimalMap.entrySet()) {
      Barn key = e.getKey();
      if (key.getColor() == animal.getFavoriteColor()) {
        matchingBarnsList.add(key);
      }

    }

    if (matchingBarnsList.size() > 0) {

      if ((matchingBarnsList.get(0).getColor() == animal.getFavoriteColor())) {
        barnFound = true;
        barnFoundObj = matchingBarnsList.get(0);
        int animalCount = barnAnimalMap.get(barnFoundObj).size();
        int animalsInMatchingColorBarn = 0;

        if (animalCount < 20) {
          Animal tempAnimal = new Animal(animal.getName(), animal.getFavoriteColor(), barnFoundObj);
          animalRepository.save(tempAnimal);

          if (matchingBarnsList.size() > 1) {
            animalResult = findAll();
            barnAnimalMap = animalResult.stream()
              .collect(Collectors.groupingBy(Animal::getBarn));
            matchingBarnsList = new ArrayList<>();

            for (Map.Entry<Barn, List<Animal>> e : barnAnimalMap.entrySet()) {
              Barn key = e.getKey();
              if (key.getColor() == animal.getFavoriteColor()) {
                matchingBarnsList.add(key);
              }
            }

            for (int j = 0; j < matchingBarnsList.size(); j++) {
//              System.out.println("****&&&&**********&&&&&&********** size is " +barnAnimalMap.get(matchingBarnsList.get(j)).size()
//                +" barn id is " +matchingBarnsList.get(j).getId()
//                +"-------" +barnAnimalMap.get(matchingBarnsList.get(j)).toString());
              animalsInMatchingColorBarn += barnAnimalMap.get(matchingBarnsList.get(j)).size();
            }

            redistribute(animalsInMatchingColorBarn, tempAnimal);

//            System.out.println("total barns for this color is " +matchingBarnsList.size()
//              +" animals in matching color barn is " +animalsInMatchingColorBarn);

            return tempAnimal;
          }
          return tempAnimal;
        }
      }
    }
    //}

    if (barnFound) {
      Barn tempBarn = new Barn(animal.getFavoriteColor().toString(), animal.getFavoriteColor());
      barnRepository.save(tempBarn);
      Animal tempAnimal = new Animal(animal.getName(), animal.getFavoriteColor(),
        tempBarn);
      animalRepository.save(tempAnimal);
      matchingBarnsList = new ArrayList<>();
      animalResult = findAll();
      barnAnimalMap = animalResult.stream()
        .collect(Collectors.groupingBy(Animal::getBarn));

      for (Map.Entry<Barn, List<Animal>> e : barnAnimalMap.entrySet()) {
        Barn key = e.getKey();
        if (key.getColor() == animal.getFavoriteColor()) {
          matchingBarnsList.add(key);
        }

      }

      if (matchingBarnsList.size() > 0) {

        if ((matchingBarnsList.get(0).getColor() == animal.getFavoriteColor())) {
          int animalsInMatchingColorBarn = 0;

          if (matchingBarnsList.size() > 1) {

            for (int j = 0; j < matchingBarnsList.size(); j++) {
              animalsInMatchingColorBarn += barnAnimalMap.get(matchingBarnsList.get(j)).size();
            }

            redistribute(animalsInMatchingColorBarn, tempAnimal);
//              System.out.println("total barns for this color is " +matchingBarnsList.size()
//                +" animals in matching color barn is " +animalsInMatchingColorBarn);
            return tempAnimal;
          }
          return tempAnimal;

        }
      }
      return tempAnimal;
    }

    else {   // barn not found need to create 2nd barn
      Barn tempBarn = new Barn(animal.getFavoriteColor().toString(), animal.getFavoriteColor());
      barnRepository.save(tempBarn);
      Animal tempAnimal = new Animal(animal.getName(), animal.getFavoriteColor(),
        tempBarn);
      animalRepository.save(tempAnimal);
      return tempAnimal;
    }
  }

  private void redistribute(int animalsInMatchingColorBarn, Animal animal) {
    // need to redistribute
    double numberOfBarnsNeeded = Math.ceil((double) animalsInMatchingColorBarn / (double) 20);
    int averageAnimalsPerBarn = (animalsInMatchingColorBarn / (int) numberOfBarnsNeeded);
    int averageAnimalsPerBarnRemainder = (animalsInMatchingColorBarn % (int) numberOfBarnsNeeded);
    int averageAnimalsPerBarnPlusRemainder = averageAnimalsPerBarn + 1;
    ArrayList<Barn> newBarnList = new ArrayList<>();
    ArrayList<Integer> barnList = new ArrayList<>();
    ArrayList<Barn> removeFromMapList = new ArrayList<>();

    List<Animal> animalResult = findAll();
    Map<Barn, List<Animal>> barnAnimalMap = animalResult.stream()
      .collect(Collectors.groupingBy(Animal::getBarn));

    for (int k = 0; k < numberOfBarnsNeeded; k++) {
      if (averageAnimalsPerBarnRemainder > 0) {
        barnList.add(averageAnimalsPerBarnPlusRemainder);
        averageAnimalsPerBarnRemainder--;
        Barn tempBarn = new Barn(animal.getFavoriteColor().toString(), animal.getFavoriteColor());
        barnRepository.save(tempBarn);
        newBarnList.add(tempBarn);
        continue;
      }
      barnList.add(averageAnimalsPerBarn);
      Barn tempBarn = new Barn(animal.getFavoriteColor().toString(), animal.getFavoriteColor());
      barnRepository.save(tempBarn);
      newBarnList.add(tempBarn);
    }

    ArrayList<ArrayList<Animal>> listOfBarnsWithAnimals = new ArrayList<ArrayList<Animal>>();
    ArrayList<Animal> tempAnimalsList = new ArrayList<Animal>();
    ArrayList<Animal> animalsList;

    for (Map.Entry<Barn, List<Animal>> e : barnAnimalMap.entrySet()) {
      Barn key = e.getKey();
      List<Animal> value = e.getValue();
      if (key.getColor() == animal.getFavoriteColor()) {
        for (int k = 0; k < value.size(); k++) {
          animalRepository.findById(value.get(k).getId()).get().setBarn(null);
          tempAnimalsList.add(value.get(k));
        }
        barnRepository.deleteById(key.getId());
        removeFromMapList.add(key);
      }

    }

    int tempAnimalsCounter = 0;

    for (int i=0; i < newBarnList.size(); i++) {
      animalsList = new ArrayList<Animal>();

      for (int k=0; k < barnList.get(i); k++) {
        if (tempAnimalsCounter < tempAnimalsList.size()) {
          animalsList.add(tempAnimalsList.get(tempAnimalsCounter));
          tempAnimalsCounter++;
        }
      }

      listOfBarnsWithAnimals.add(animalsList);
    }



    for (int i=0; i < removeFromMapList.size(); i++) {
        barnAnimalMap.remove(removeFromMapList.get(i));
    }

    for (int i=0; i < newBarnList.size(); i++) {
      barnAnimalMap.put(newBarnList.get(i), listOfBarnsWithAnimals.get(i));
    }

    int iterationNumber = 0;

    for (Map.Entry<Barn, List<Animal>> entry : barnAnimalMap.entrySet()) {

      Barn barn = entry.getKey();
      List<Animal> animals = entry.getValue();
      if (barn.getColor() == animal.getFavoriteColor()) {
        for (int k = 0; k < animals.size(); k++) {
          animalRepository.findById(animals.get(k).getId()).get().setBarn(newBarnList.get(iterationNumber));
        }
        iterationNumber++;
      }
    }
  }

  @Override
  public void addToFarm(List<Animal> animals) {
    animals.forEach(this::addToFarm);
  }

  @Override
  public void removeFromFarm(Animal animal) {

//    deleteCount++;
//    System.out.println("DELETE COUNT IS " +deleteCount);

    List<Barn> matchingBarnsList;
    int animalsInMatchingColorBarn = 0;

    animalRepository.delete(animal);

    List<Animal> animalResult = findAll();
    Map<Barn, List<Animal>> barnAnimalMap = animalResult.stream()
      .collect(Collectors.groupingBy(Animal::getBarn));
    matchingBarnsList = new ArrayList<>();

    for (Map.Entry<Barn, List<Animal>> e : barnAnimalMap.entrySet()) {
      Barn key = e.getKey();
      if (key.getColor() == animal.getFavoriteColor()) {
        matchingBarnsList.add(key);
      }

    }

    for (int j = 0; j < matchingBarnsList.size(); j++) {
      if (barnAnimalMap.get(matchingBarnsList.get(j)) == null) {
        barnRepository.deleteById(matchingBarnsList.get(j).getId());
        matchingBarnsList.remove(j);
        continue;
      }
      animalsInMatchingColorBarn+=barnAnimalMap.get(matchingBarnsList.get(j)).size();
    }

    if (matchingBarnsList.size() > 0) {
      redistribute(animalsInMatchingColorBarn, animal);
    }

  }

  @Override
  public void removeFromFarm(List<Animal> animals) {
    animals.forEach(animal -> removeFromFarm(animalRepository.getOne(animal.getId())));
  }
}
