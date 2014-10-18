package no.bera.thePrince.domain.family;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FamilyApplicationService {
    public void establishFamily(FamilyId familyId, NobleId paterfamilias, String familyName){
        new Family(eventStore.get(familyId));
        family.establishNewFamily(familyId);
        eventStore.save(family);
    }

    public void dissolveFamily(FamilyId familyId){
        throw new NotImplementedException();
    }

    public void changePaterfamilias(){

    }
}
