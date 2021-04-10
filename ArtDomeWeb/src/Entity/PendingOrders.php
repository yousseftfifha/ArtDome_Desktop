<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * PendingOrders
 *
 * @ORM\Table(name="pending_orders", indexes={@ORM\Index(name="fk_oeuvres", columns={"OeuvreID"}), @ORM\Index(name="fk_us", columns={"IDUser"})})
 * @ORM\Entity
 */
class PendingOrders
{
    /**
     * @var int
     *
     * @ORM\Column(name="ID_PendingOrder", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idPendingorder;

    /**
     * @var int
     *
     * @ORM\Column(name="OrderID", type="integer", nullable=false)
     */
    private $orderid;

    /**
     * @var int|null
     *
     * @ORM\Column(name="InnoNumber", type="integer", nullable=true)
     */
    private $innonumber;

    /**
     * @var int|null
     *
     * @ORM\Column(name="Quantity", type="integer", nullable=true)
     */
    private $quantity;

    /**
     * @var string|null
     *
     * @ORM\Column(name="Status", type="string", length=30, nullable=true, options={"default"="Pending"})
     */
    private $status = 'Pending';

    /**
     * @var \Oeuvre
     *
     * @ORM\ManyToOne(targetEntity="Oeuvre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="OeuvreID", referencedColumnName="ID_Oeuvre")
     * })
     */
    private $oeuvreid;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IDUser", referencedColumnName="ID")
     * })
     */
    private $iduser;


}
