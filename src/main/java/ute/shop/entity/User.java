package ute.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;

	@Column(nullable = false, length = 32)
	private String firstname;

	@Column(nullable = false, length = 32)
	private String lastname;

	@Column(unique = true)
	private String slug;

	@Column(unique = true)
	private String id_card;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String phone;

	@Column(nullable = false)
	private Boolean isEmailActive = false;

	@Column(nullable = false)
	private Boolean isPhoneActive = false;

	@Column(nullable = false)
	private String salt;

	@Column(nullable = false)
	private String hashed_password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role = Role.USER;

	@ElementCollection
	@Column(length = 200)
	private List<String> addresses = new ArrayList<>();

	private String avatar;
	private String cover;

	@Column(nullable = false)
	private Integer point = 0;

	@Column(nullable = false)
	private double e_wallet = 0.0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	public enum Role {
		USER, ADMIN
	}

	// Relationship to UserLevel
	@ManyToOne
	@JoinColumn(name = "userLevel_id", referencedColumnName = "_id")
	private UserLevel userLevel;
	// One-to-One Relationship to Store
	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Store ownedStore;

	@ManyToMany(mappedBy = "staffs")
	private List<Store> staffedStores;

	@OneToMany(mappedBy = "user") // MappedBy points to the field in Transaction referencing User
	private List<Transaction> transactions;
	@OneToMany(mappedBy = "user") // Mối quan hệ One-to-Many với Review
	private List<Review> reviews = new ArrayList<>();
	@OneToMany(mappedBy = "user") // MappedBy chỉ đến thuộc tính 'user' trong UserFollowStore
	private List<UserFollowStore> userFollowStores = new ArrayList<>();
	@OneToMany(mappedBy = "user") // Mối quan hệ One-to-Many với Order
	private List<Order> orders = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<Cart> carts = new ArrayList<>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserFollowProduct> userFollowProducts = new ArrayList<>();

}
