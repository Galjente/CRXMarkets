package eu.galjente.crxmarkets

import spock.lang.Specification


class RainyHillsBeanSpecification extends Specification {

  private final static Integer FIRST_HILL_HEIGHT = 5
  private final static Integer MIDDLE_HILL_HEIGHT = 2
  private final static Integer LAST_HILL_HEIGHT = 3
  private final static Integer[] HILL_ARRAY = [FIRST_HILL_HEIGHT, MIDDLE_HILL_HEIGHT, LAST_HILL_HEIGHT]

  def rainyHillsService = Mock(RainyHillsService)

  def "Check bean default values"() {
    when:
      RainyHillsBean bean = new RainyHillsBean()

    then:
      bean.hillHeight == null
      bean.waterVolume == 0
      bean.hills == []
  }

  def "Add one hill"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService

    when:
      bean.hillHeight = FIRST_HILL_HEIGHT
      bean.add()

    then:
      bean.hills
      !bean.hillHeight
      bean.hills.size() == 1
      FIRST_HILL_HEIGHT in bean.hills
      1 * rainyHillsService.calculate(bean.hills)
  }

  def "Add two hills"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService

    when:
      bean.hillHeight = FIRST_HILL_HEIGHT
      bean.add()

      bean.hillHeight = LAST_HILL_HEIGHT
      bean.add()

    then:
      bean.hills
      !bean.hillHeight
      bean.hills.size() == 2
      bean.hills == [FIRST_HILL_HEIGHT, LAST_HILL_HEIGHT]
      2 * rainyHillsService.calculate(bean.hills)
  }

  def "Add hill with null height"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService

    when:
      bean.add()

    then:
      !bean.hillHeight
      bean.hills == []
      0 * rainyHillsService.calculate(bean.hills)
  }

  def "Delete hill in empty array"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService

    when:
      bean.delete(0)

    then:
      bean.hills == []
      0 * rainyHillsService.calculate(bean.hills)
  }

  def "Delete first hill in array with 3 hills"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService
      bean.hills = HILL_ARRAY

    when:
      bean.delete(0)

    then:
      bean.hills
      bean.hills.size() == 2
      bean.hills == [MIDDLE_HILL_HEIGHT, LAST_HILL_HEIGHT]
      1 * rainyHillsService.calculate(bean.hills)
  }

  def "Delete last hill in array with 3 hills"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService
      bean.hills = HILL_ARRAY

    when:
      bean.delete(2)

    then:
      bean.hills
      bean.hills.size() == 2
      bean.hills == [FIRST_HILL_HEIGHT, MIDDLE_HILL_HEIGHT]
      1 * rainyHillsService.calculate(bean.hills)
  }

  def "Delete middle hill in array with 3 hills"() {
    given:
      RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService
      bean.hills = HILL_ARRAY

    when:
      bean.delete(1)

    then:
      bean.hills
      bean.hills.size() == 2
      bean.hills == [FIRST_HILL_HEIGHT, LAST_HILL_HEIGHT]
      1 * rainyHillsService.calculate(bean.hills)
  }

  def "Delete hill outside array"() {
    given:
    RainyHillsBean bean = new RainyHillsBean()
      bean.rainyHillsService = rainyHillsService
      bean.hills = HILL_ARRAY

    when:
      bean.delete(3)

    then:
      bean.hills
      bean.hills.size() == 3
      bean.hills == HILL_ARRAY
  }

}
