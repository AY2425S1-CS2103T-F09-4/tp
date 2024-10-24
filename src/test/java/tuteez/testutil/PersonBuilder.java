package tuteez.testutil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import tuteez.model.person.Address;
import tuteez.model.person.Email;
import tuteez.model.person.Name;
import tuteez.model.person.Person;
import tuteez.model.person.Phone;
import tuteez.model.person.TelegramUsername;
import tuteez.model.person.lesson.Lesson;
import tuteez.model.remark.RemarkList;
import tuteez.model.tag.Tag;
import tuteez.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_TELEGRAM = "amy_bee";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private TelegramUsername telegramUsername;
    private Set<Tag> tags;
    private Set<Lesson> lessons;
    private RemarkList remarkList;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        telegramUsername = TelegramUsername.of(DEFAULT_TELEGRAM);
        tags = new HashSet<>();
        lessons = new HashSet<>();
        remarkList = new RemarkList();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        telegramUsername = personToCopy.getTelegramUsername();
        tags = new HashSet<>(personToCopy.getTags());
        remarkList = new RemarkList(new ArrayList<>(personToCopy.getRemarkList().getRemarks()));
        lessons = new HashSet<>(personToCopy.getLessons());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Parses the {@code lessons} into a {@code Set<Lesson>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withLessons(String ... lessons) {
        this.lessons = SampleDataUtil.getLessonSet(lessons);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code TelegramUsername} of the {@code Person} that we are building.
     */
    public PersonBuilder withTelegram(String telegramUsername) {
        if (telegramUsername == null) {
            this.telegramUsername = TelegramUsername.empty();
        } else {
            this.telegramUsername = TelegramUsername.of(telegramUsername);
        }
        return this;
    }

    /**
     * Sets the {@code RemarkList} of the {@code Person} that we are building.
     */
    public PersonBuilder withRemarks(RemarkList remarkList) {
        this.remarkList = new RemarkList(new ArrayList<>(remarkList.getRemarks()));
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, telegramUsername, tags, lessons, remarkList);
    }

}