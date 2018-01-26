package eu.galjente.crxmarkets;

import spock.lang.Specification;

class RainyHillsServiceSpec extends Specification {

  def "Calculate one hill"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5])

    then:
      waterVolume == 0
  }

  def "Calculate two similar hills"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5, 5])

    then:
      waterVolume == 0
  }

  def "Calculate two hills, first lowest"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([1, 5])

    then:
      waterVolume == 0
  }

  def "Calculate two hills, last lowest"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5, 1])

    then:
      waterVolume == 0
  }

  def "Calculate three similar hills"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5, 5, 5])

    then:
      waterVolume == 0
  }

  def "Calculate three hills, first lowest"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([1, 5, 5])

    then:
      waterVolume == 0
  }

  def "Calculate three hills, last lowest"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5, 5, 1])

    then:
      waterVolume == 0
  }

  def "Calculate three hills, middle lowest"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([5, 1, 5])

    then:
      waterVolume == 4
  }

  def "Calculate 6 hills"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([0, 3, 1, 5, 0, 4])

    then:
      waterVolume == 6
  }

  def "Calculate first example"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([3, 2, 4, 1, 2])

    then:
      waterVolume == 2
  }

  def "Calculate second example"() {
    given:
      RainyHillsService service = new RainyHillsService()

    when:
      Integer waterVolume = service.calculate([4, 1, 1, 0, 2, 3])

    then:
      waterVolume == 8
  }
}